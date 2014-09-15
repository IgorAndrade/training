/**
 * 
 */

var form = {
	init : function() {
		$("#salvar").click(function() {
			var dados = $("form").serialize();
			user.salvarUsuario(dados);
		});
		$("#email").blur(function() {
			user.checkEmail($(email).val());
		});

		user.populaTipoTel();

		$(document).on('click', '.btn-add', addFormGroup);
		$(document).on('click', '.btn-remove', removeFormGroup);
		$(document).on('click', '.dropdown-menu a', selectFormGroup);

	}
};

user = {
	checkEmail : function(email) {
		$.get("user/UserByEmail?email=" + email, function(res) {
			if (res.success) {
				erro.add("#email", message.get(
						"erro.regranegocio.emailRepetido", null));
			}
		});
	},

	salvarUsuario : function(dados) {
		var array = $("form").serializeArray();
		var usuario = toJson(array);
		usuario = this.trataUserTels(usuario);
		$.post("user/salvar", usuario, function(res) {
			if (res.success) {
				message.success(res.message);
			} else
				message.error(res.message);
		});
	},

	trataUserTels:function(user){
		var tipos = user.tipo;
		var telefones = user.telefone;
		var listTelefones =[];
		$.each(tipos,function(k,v){
			var o = {};
			o['tipo'] = v;
			o['telefone'] = telefones[k];
		//	o['"@class'] = 'br.com.irsa.training.model.Telefone';
			listTelefones.push(o);
		});
		 user.tipo=null;
		 user.telefone=null;
		user['tels'] = listTelefones;
		return user;
	},
	
	populaTipoTel : function() {
		$.ajax({
			url : "user/telefoneTipos",
			type : 'GET',
			async : false,
			success : function(tipos) {
				var ui = $(".input-group-select > ul");
				$.each(tipos, function(key, tipo) {
					ui.append('<li><a href="#' + tipo + '">' + tipo
							+ '</a></li>');
				});
			}
		});

	}

};

erro = {
	add : function(campo, msg) {
		$(campo).parent().addClass("has-error");
		$(campo).siblings(".help-block").text(msg);
		$(campo).focus(function() {
			erro.clear(campo);
		});
	},

	clear : function(campo) {
		$(campo).parent().removeClass("has-error");
		$(campo).siblings(".help-block").text("");
	},

};

message = {

	success : function(msg) {
		alert = '<div class="alert alert-success" role="alert">'
				+ '<strong>Sucesso!</strong> ' + msg + '</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
		$('div.alert').hover(function() {
			message.clean();
		});
	},

	info : function(msg) {
		alert = '<div class="alert alert-info" role="alert">'
				+ '<strong>Info!</strong> ' + msg + '</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
		$('div.alert').hover(function() {
			message.clean();
		});
	},

	error : function(msg) {
		alert = '<div class="alert alert-danger" role="alert">'
				+ '<strong>Erro!</strong> ' + msg + '</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
		$('div.alert').hover(function() {
			message.clean();
		});
	},

	clean : function() {
		$('div.alert').remove();
	},

	get : function(cod, param) {
		var url = "message?cod=" + cod;
		var retorno = null;
		if (param != null || param != "")
			url += "&param=" + param;
		$.ajax({
			url : url,
			type : 'GET',
			async : false,
			success : function(resp) {
				retorno = resp;
			}
		});
		return retorno;
	}
};

function toJson(array) {
	var o = {};
	$.each(array, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
}

// Trata telefones
var addFormGroup = function(event) {
	event.preventDefault();

	var $formGroup = $(this).closest('.form-group');
	var $multipleFormGroup = $formGroup.closest('.multiple-form-group');
	var $formGroupClone = $formGroup.clone();

	$(this).toggleClass('btn-success btn-add btn-danger btn-remove').html('–');

	$formGroupClone.find('input').val('');
	$formGroupClone.find('.concept').text('Phone');
	$formGroupClone.insertAfter($formGroup);

	var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
	total = $multipleFormGroup.data('max');
	if ($multipleFormGroup.data('max') <= countFormGroup($multipleFormGroup)) {
		$lastFormGroupLast.find('.btn-add').attr('disabled', true);
	}
};

var removeFormGroup = function(event) {
	event.preventDefault();

	var $formGroup = $(this).closest('.form-group');
	var $multipleFormGroup = $formGroup.closest('.multiple-form-group');

	var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
	if ($multipleFormGroup.data('max') >= countFormGroup($multipleFormGroup)) {
		$lastFormGroupLast.find('.btn-add').attr('disabled', false);
	}

	$formGroup.remove();
};

var selectFormGroup = function(event) {
	event.preventDefault();

	var $selectGroup = $(this).closest('.input-group-select');
	var param = $(this).attr("href").replace("#", "");
	var concept = $(this).text();

	$selectGroup.find('.concept').text(concept);
	$selectGroup.find('.input-group-select-val').val(param);

};

var countFormGroup = function($form) {
	return $form.find('.form-group').length;
};
