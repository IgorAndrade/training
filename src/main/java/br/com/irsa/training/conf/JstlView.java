package br.com.irsa.training.conf;
import java.util.Iterator;
import java.util.Map;
 

import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 




import org.springframework.web.servlet.view.InternalResourceView;
 
public class JstlView extends InternalResourceView {
 
 @Override
 protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
 
 // Determine the path for the request dispatcher.
 String dispatcherPath = prepareForRendering(request, response);
 
 // set original view being asked for as a request parameter
 //request.setAttribute("body", dispatcherPath.substring(dispatcherPath.lastIndexOf("/") + 1));
 request.setAttribute("body", dispatcherPath);

// force everything to be template.jsp
 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/template/tamplate.jsp");
 modelAsRequestAttribute(model, request);
 requestDispatcher.include(request, response);
 
 }
 
private void modelAsRequestAttribute(Map model, HttpServletRequest request){
	Set<String> set = model.keySet();
	 for(String key : set){
		 request.setAttribute(key, model.get(key));
	 }
 }
 
}