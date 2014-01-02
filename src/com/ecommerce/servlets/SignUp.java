package com.ecommerce.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.entities.User;
import com.ecommerce.forms.SignUpForm;

/**
 * Servlet implementation class Register
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String VIEWPAGE      = "/WEB-INF/signup.jsp";

    // EJB Injection 
    @EJB
    private UserDAO   userDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//     display register page
        this.getServletContext().getRequestDispatcher( VIEWPAGE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// prepare form 
        SignUpForm form = new SignUpForm( userDAO );

        // process request and get resulting created user 
        User newUser = form.signUpUser( request );

        // store form and user objects in the request object 
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, newUser );

        this.getServletContext().getRequestDispatcher( VIEWPAGE ).forward( request, response );    
	}

}