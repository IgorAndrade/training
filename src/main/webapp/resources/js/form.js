/**
 * 
 */

var form={
	init: function(){
			
			alert('a');
			$("#salvar").click(function(){
				form = $( "form" ).serialize();
				alert(form);
			});
			
			
		},
		
	
	novo:{}
		
		
};

form.init.user();
