package br.com.irsa.training.controller;

public class JsonResponse {
		public static final String SUCCESS = "SUCCESS";
		public static final String FAIL = "FAIL";
		private String status = null;
	    private Object result = null;
	    private String message =null;
	    
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	    public Object getResult() {
	        return result;
	    }
	    public void setResult(Object result) {
	        this.result = result;
	    }
	    
	    public boolean isSuccess(){
	    	return this.status.equalsIgnoreCase(SUCCESS);
	    }
	    
	    public String getMessage() {
			return message;
		}
	    public void setMessage(String message) {
			this.message = message;
		}

}
