/**
 * 
 */

var form={
	init: function(){
			$("#salvar").click(function(){
				var dados = $( "form" ).serialize();
				user.salvarUsuario(dados);
			});
			$("#email").blur(function(){user.checkEmail($(email).val());});
			
			
		}
};

user = {
	checkEmail:function(email){
		$.get("user/UserByEmail?email="+email,function(res){
			if(res.success){
				message.get("erro.regranegocio.emailRepetido", null, function(resp){
					erro.add("#email", resp);
				});
			}
		});
	},
	salvarUsuario:function(dados){
		$.post("user/salvar",dados,function(res){
			if(res.success){
				message.success(res.message);
			}else
				message.error(res.message);
		});
	}
		
};

erro = {
	add:function(campo,msg){
		$(campo).parent().addClass("has-error");
		$(campo).siblings(".help-block").text(msg);
		$(campo).focus(function(){erro.clear(campo); });
	},
	
	clear:function(campo){
		$(campo).parent().removeClass("has-error");
		$(campo).siblings(".help-block").text("");
	},
	
} ;

message={
		
	success:function(msg){
		alert= '<div class="alert alert-success" role="alert">'+
		'<strong>Sucesso!</strong> '+msg+'</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
		$('div.alert').hover(function(){message.clean();});
	},

	info:function(msg){
		alert= '<div class="alert alert-info" role="alert">'+
		'<strong>Info!</strong> '+msg+'</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
		$('div.alert').hover(function(){message.clean();});
	},
	
	error:function(msg){
		alert= '<div class="alert alert-danger" role="alert">'+
		'<strong>Erro!</strong> '+msg+'</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
		$('div.alert').hover(function(){message.clean();});
	},
	
	clean:function(){
		$('div.alert').remove();
	},
	
	get:function(cod,param,funcao){
		var url= "message?cod="+cod;
		if(param != null || param != "")
			url+="&param="+param;
		$.get(url,funcao);
	}
};
