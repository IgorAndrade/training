/**
 * 
 */

var form={
	init: function(){
			$("#salvar").click(function(){
				var dados = $( "form" ).serialize();
				user.salvarUsuario(dados);
			});
			$("#email").blur(function(){user.checkEmail("#email");});
			
			
		}
};

user = {
	checkEmail:function(email){
		$.post("user/UserByEmail",$(email).serialize(),function(res){
			if(res.success){
				erro.add("#email", res.message);
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
	},

	info:function(msg){
		alert= '<div class="alert alert-info" role="alert">'+
		'<strong>Info!</strong> '+msg+'</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
	},
	
	error:function(msg){
		alert= '<div class="alert alert-danger" role="alert">'+
		'<strong>Erro!</strong> '+msg+'</div>';
		this.clean();
		$('#corpo > .row').first().before(alert);
	},
	
	clean:function(){
		$('div.alert').remove();
	}
};
