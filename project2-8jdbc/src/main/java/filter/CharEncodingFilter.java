package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

/**
 * Servlet Filter implementation class CharEncodingFilter
 */
/**
 * This filter is responsible for setting the character encoding for incoming requests.
 * It implements the Filter interface and extends the HttpFilter class.
 */
@WebFilter(filterName = "/CharEncodingFilter", urlPatterns = "/*")
public class CharEncodingFilter extends HttpFilter implements Filter {

	private String encoding;

	/**
	 * Constructs a new CharEncodingFilter.
	 */
	public CharEncodingFilter() {
		super();
	}

	/**
	 * Called by the web container to indicate to a filter that it is being taken out of service.
	 * This method is only called once all threads within the filter's doFilter method have exited or after a timeout period has passed.
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * The doFilter method of the Filter is called by the container each time a request/response pair is passed through the chain due to a client request for a resource at the end of the chain.
	 * This method sets the character encoding for the request and passes it along the filter chain.
	 *
	 * @param request  the ServletRequest object containing the client's request
	 * @param response the ServletResponse object containing the filter's response
	 * @param chain    the FilterChain for invoking the next filter or the resource
	 * @throws IOException      if an I/O related error occurs during the processing of the request or response
	 * @throws ServletException if a servlet-related error occurs during the processing of the request or response
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	/**
	 * Called by the web container to indicate to a filter that it is being placed into service.
	 * This method is called before any requests are passed to the filter.
	 *
	 * @param fConfig the FilterConfig object that contains the filter's configuration and initialization parameters
	 * @throws ServletException if the initialization fails
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "utf-8";
		}
	}

}
