package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


public class UserDeatilsServiceImplTests {

    @InjectMocks // it will inject all the components of the app and additonally automatically creates instance i.e
    // also does the work of autowired
    private UserDetailServiceImpl userDetailService;

    @Mock
    private UserRepository userRepository;
    @BeforeEach // it will initialize mocks of this class i.e userRepository
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTests() {
        User mockUser = new User();
        mockUser.setUserName("Isha");
        mockUser.setPassword("Jain");
        mockUser.setRoles(new ArrayList<>());

        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(mockUser);

        UserDetails user = userDetailService.loadUserByUsername("virat");
        assert user != null;
        assert user.getUsername().equals("Isha");
    }
}