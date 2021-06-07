package jp.co.aforce.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.EmployeeDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/jp.co.aforce.login/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String url = null; //転送先
		
		//リクエストパラメータの取得
			String user_id = request.getParameter("user_id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");

			
			try {
				// DAO生成
				EmployeeDAO dao = new EmployeeDAO();

				// DAO利用
				if (dao.loginCheck(user_id, password)) {
					// セッションスコープ
					HttpSession session = request.getSession();

					// セッションスコープ設定
					session.setAttribute("user_id", user_id);
					session.setAttribute("name", name);
					
					// ログイン認証
					url = "../jsp/accept.jsp";


				} else {
					// ログイン未認証
					url = "../jsp/login.jsp";
					request.setAttribute("message", "*エラー　IDもしくはパスワードが違います");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			//リクエスト転送
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}

	}
