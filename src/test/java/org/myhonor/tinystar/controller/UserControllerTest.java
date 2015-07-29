package org.myhonor.tinystar.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.myhonor.tinystar.entity.User;
import org.myhonor.tinystar.service.IUserService;

public class UserControllerTest
{
    private final String username = "myhonor";
    private final String password = "myhonor";
    private final User user = new User(username, password);
    
    @BeforeClass
    public static void setUp() throws Exception
    {
    }
    
    @AfterClass
    public static void tearDown() throws Exception
    {
    }
    
    @Test
    public void loginWithUsernameAndPassword() throws Exception
    {
        IUserService userService = mock(IUserService.class);
        when(userService.countUser(user)).thenReturn(1);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        UserController userController = new UserController();
        userController.login(request, response, new User());
        verify(userService, times(1)).countUser(user);
    }
}
