//package com.blogposts.blogpostservice.service;
//
//import com.blogposts.blogpostservice.dto.GetUserDto;
//import com.blogposts.blogpostservice.dto.IdDto;
//import com.blogposts.blogpostservice.dto.view.CreateViewDto;
//import com.blogposts.blogpostservice.dto.view.GetViewDto;
//import com.blogposts.blogpostservice.entity.Blogpost;
//import com.blogposts.blogpostservice.entity.view.BlogpostView;
//import com.blogposts.blogpostservice.mapper.ViewMapper;
//import com.blogposts.blogpostservice.mapper.ViewMapperImpl;
//import com.blogposts.blogpostservice.repository.ReactionRepository;
//import com.blogposts.blogpostservice.repository.ViewRepository;
//import com.blogposts.blogpostservice.service.impl.InteractionServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.web.client.ResourceAccessException;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.argThat;
//
//@ExtendWith(MockitoExtension.class)
//public class InteractionServiceImplTest {
//    @InjectMocks
//    private InteractionServiceImpl interactionServiceImpl;
//
//    @Mock
//    private ReactionRepository reactionRepository;
//
//    @Mock
//    private ViewRepository viewRepository;
//
//    @Mock
//    private APIClient apiClient;
//
//    @Mock
//    private ViewMapper viewMapper;
//
//    @BeforeEach
//    public void setUp() {
//        Mockito.when(apiClient.getUser(1L)).thenReturn(new GetUserDto(
//                1L,
//                "kozachenko1",
//                null,
//                null,
//                LocalDateTime.now()
//        ));
//        Mockito.when(viewRepository.findById(argThat(arg -> arg.getUserId() == 1L && arg.getBlogpost() == 1L)))
//                .thenReturn(Optional.empty());
//        Mockito.when(viewRepository.findById(argThat(arg -> arg.getUserId() == 1L && arg.getBlogpost() == 2L)))
//                .thenReturn(Optional.of(new BlogpostView(
//                        1L,
//                        new Blogpost(2L, 3L, "test tweet", LocalDateTime.now(), null, null),
//                        LocalDateTime.now())
//                ));
//        Mockito.when(viewRepository.save(any(BlogpostView.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);
//    }
//
//    @Test
//    public void viewPost_whenNotViewed_byUser1() {
//        GetViewDto getViewDto = this.interactionServiceImpl.viewPost(new CreateViewDto(
//                new IdDto(1L),
//                new IdDto(1L),
//                LocalDateTime.now()
//        ));
//        assertThat(getViewDto).isNotNull();
//    }
//
//    @Test
//    public void viewPost_whenViewed_byUser1() {
//        assertThrows(
//                ResourceAccessException.class,
//                () -> {
//                    GetViewDto getViewDto = this.interactionServiceImpl.viewPost(new CreateViewDto(
//                            new IdDto(1L),
//                            new IdDto(2L),
//                            LocalDateTime.now()
//                    ));
//                }
//        );
//    }
//}
