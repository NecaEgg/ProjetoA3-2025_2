package br.com.safe_line.safeline.config;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CookieServiceTest {

    @Test
    void addAndClearCookie_callsResponse() {
        HttpServletResponse response = mock(HttpServletResponse.class);

        CookieService cookieService = new CookieService();

        cookieService.addSecureCookie(response, "test", "val", 3600);
        cookieService.clearCookie(response, "test");

        // addSecureCookie and clearCookie both call response.addCookie
        verify(response, times(2)).addCookie(any(Cookie.class));
    }

}
