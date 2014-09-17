/**
 * 
 */

var form = {
	init : function() {
		$("#salvar").click(function() {
		//	var dados = $("form").serialize();
		//	user.salvarUsuario("form");
			erro.add("input[name='telefones[0].tipo']", "nao preehsh");
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

	
	salvarUsuario : function(form) {
		var usuario = $(form).toObject({mode: 'first'});
		var strUsuario = JSON.stringify(usuario);
		$.ajax({
			url:"user/salvar",
			type:"POST",
			contentType:"application/json;charset=UTF-8",
			data:strUsuario,
			success:function(res) {
				if (res.success) {
					message.success(res.message);
				} else
					message.error(res.message);
			}
		});
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

// Trata telefones
var addFormGroup = function(event) {
	event.preventDefault();

	var $formGroup = $(this).closest('.form-group');
	var $multipleFormGroup = $formGroup.closest('.multiple-form-group');
	var $formGroupClone = $formGroup.clone();

	$(this).toggleClass('btn-success btn-add btn-danger btn-remove').html('–');

	$formGroupClone.find('input').val('');
	$formGroupClone.find('.concept').text('Tipo:');
	$formGroupClone.insertAfter($formGroup);

	var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
	total = $multipleFormGroup.data('max');
	if ($multipleFormGroup.data('max') <= countFormGroup($multipleFormGroup)) {
		$lastFormGroupLast.find('.btn-add').attr('disabled', true);
	}
	renameFormGroup();
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
	renameFormGroup();
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

function renameFormGroup(){
	var i=0;
	$('.tipo').each(function() {
	    this.name= this.name.replace( this.name.match(/\[[0-9]+\]/), '['+i+']');
	    i++;
	});
	i=0;
	$('.numero').each(function() {
		this.name= this.name.replace(this.name.match(/\[[0-9]+\]/), '['+i+']');
		i++;
	});
}
