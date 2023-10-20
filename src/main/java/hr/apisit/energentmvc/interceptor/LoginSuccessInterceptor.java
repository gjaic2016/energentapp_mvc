package hr.apisit.energentmvc.interceptor;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component
@Slf4j
public class LoginSuccessInterceptor extends SavedRequestAwareAuthenticationSuccessHandler {
//    private static final Logger logger = LoggerFactory.getLogger(LoginSuccessInterceptor.class);

//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        // Log the login event
//        logger.info("User " + authentication.getName() + " logged in.");
//
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
}
