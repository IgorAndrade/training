/**
 * Funções 
 */

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