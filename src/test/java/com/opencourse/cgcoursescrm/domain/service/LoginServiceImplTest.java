package com.opencourse.cgcoursescrm.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import java.util.Optional;
import com.opencourse.cgcoursescrm.domain.model.User;
import com.opencourse.cgcoursescrm.domain.repository.UserRepository;
import com.opencourse.cgcoursescrm.exception.PasswordIncorrectException;
import com.opencourse.cgcoursescrm.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class LoginServiceImplTest {

    @Mock
    private UserRepository personRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private LoginServiceImpl loginService;

//  @BeforeEach
//  public void setUp() {
//    loginService = new LoginServiceImpl(passwordEncoder, personRepository, tokenService);
//  }

    @Test
    void shouldReturnTokenWhenCredentialsAreValid() {
        // given
        String email = "test@example.com";
        String rawPassword = "password";
        String encodedPassword = "encodedPassword";
        User user = new User();
        user.setEmail(email);
        user.setPassword(encodedPassword);

        when(personRepository.findByEmailIgnoreCase(email)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(rawPassword, encodedPassword)).thenReturn(true);
        when(tokenService.createToken(user)).thenReturn("token123");

        // when
        String token = loginService.login(email, rawPassword);

        // then
        assertEquals("token123", token);

        verify(personRepository).findByEmailIgnoreCase(email);
        verify(passwordEncoder).matches(rawPassword, encodedPassword);
        verify(tokenService).createToken(user);
    }

    @Test
    void shouldThrowPersonNotFoundExceptionWhenPersonDoesNotExist() {
        // given
        String email = "nonexistent@example.com";
        String rawPassword = "password";

        when(personRepository.findByEmailIgnoreCase(email)).thenReturn(Optional.empty());

        // when & then
        assertThrows(UserNotFoundException.class, () -> loginService.login(email, rawPassword));

        verify(personRepository).findByEmailIgnoreCase(email);
        verifyNoMoreInteractions(passwordEncoder, tokenService);
    }

    @Test
    void shouldThrowPasswordIncorrectExceptionWhenPasswordDoesNotMatch() {
        // given
        String email = "test@example.com";
        String rawPassword = "wrongPassword";
        String encodedPassword = "encodedPassword";
        User user = new User();
        user.setEmail(email);
        user.setPassword(encodedPassword);

        when(personRepository.findByEmailIgnoreCase(email)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(rawPassword, encodedPassword)).thenReturn(false);

        // when & then
        assertThrows(PasswordIncorrectException.class, () -> loginService.login(email, rawPassword));

        verify(personRepository).findByEmailIgnoreCase(email);
        verify(passwordEncoder).matches(rawPassword, encodedPassword);
        verifyNoInteractions(tokenService);
    }
}