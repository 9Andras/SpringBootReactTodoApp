package com.gdn.fullstack.SpringBootReactTodoApp.datapopulation;

import com.gdn.fullstack.SpringBootReactTodoApp.model.todo.Todo;
import com.gdn.fullstack.SpringBootReactTodoApp.model.todo.TodoRepository;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.User;
import com.gdn.fullstack.SpringBootReactTodoApp.model.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DataPopulationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final String[][] todosData = {
            {"Buy groceries", "Don't forget the milk!", "2024-03-10T10:00:00"},
            {"Finish work project", "Deadline is approaching.", "2024-06-20T17:00:00"},
            {"Go for a run", "5 kilometers today.", "2024-01-15T08:00:00"},
            {"Read a book", "Science fiction novel.", "2024-07-05T20:00:00"},
            {"Call mom", "Check how she's doing.", "2024-02-12T18:00:00"},
            {"Plan weekend trip", "Explore new hiking trails.", "2024-04-08T09:00:00"},
            {"Learn a new recipe", "Try cooking something exotic.", "2024-09-14T12:00:00"},
            {"Practice guitar", "Master that solo.", "2024-05-21T16:00:00"},
            {"Watch a documentary", "History or science theme.", "2024-11-30T19:00:00"},
            {"Organize closet", "Donate unused clothes.", "2024-08-10T14:00:00"},
            {"Write in journal", "Reflect on the day.", "2024-12-15T21:00:00"},
            {"Fix leaky faucet", "Call plumber if needed.", "2024-03-22T13:00:00"},
            {"Volunteer at local shelter", "Help those in need.", "2024-04-17T15:00:00"},
            {"Create a budget", "Plan expenses for the month.", "2024-01-25T11:00:00"},
            {"Practice mindfulness", "Meditate for 15 minutes.", "2024-05-03T06:00:00"},
            {"Visit art gallery", "Appreciate local artists.", "2024-09-07T17:00:00"},
            {"Learn a new language", "Start with basic phrases.", "2024-06-14T10:00:00"},
            {"Plant flowers in the garden", "Brighten up the backyard.", "2024-07-19T08:00:00"},
            {"Take a photography walk", "Capture interesting scenes.", "2024-10-02T16:00:00"},
            {"Go to the dentist", "Annual check-up.", "2024-03-05T09:00:00"},
            {"Clean the garage", "Organize tools and boxes.", "2024-08-23T13:00:00"},
            {"Write a poem", "Express creativity.", "2024-05-27T18:00:00"},
            {"Attend a concert", "Enjoy live music.", "2024-11-12T20:00:00"},
            {"Join a book club", "Discuss literature.", "2024-02-20T19:00:00"},
            {"Bake cookies", "Try a new recipe.", "2024-04-30T14:00:00"},
            {"Update resume", "Add recent experience.", "2024-06-18T11:00:00"},
            {"Go hiking", "Explore a new trail.", "2024-07-29T07:00:00"},
            {"Host a dinner party", "Invite friends over.", "2024-12-08T18:00:00"},
            {"Visit a museum", "Learn something new.", "2024-10-15T10:00:00"},
            {"Paint a picture", "Get creative with colors.", "2024-09-28T15:00:00"},
            {"Attend a workshop", "Learn a new skill.", "2024-03-12T13:00:00"},
            {"Go on a road trip", "Explore new places.", "2024-06-25T09:00:00"},
            {"Write a letter", "Reconnect with an old friend.", "2024-01-20T18:00:00"},
            {"Cook a fancy dinner", "Experiment with new cuisine.", "2024-07-11T19:00:00"},
            {"Visit a farmer's market", "Buy fresh produce.", "2024-04-05T09:00:00"},
            {"Have a picnic", "Enjoy the outdoors.", "2024-05-30T12:00:00"},
            {"Attend a seminar", "Gain professional knowledge.", "2024-09-22T15:00:00"},
            {"Do a puzzle", "Challenge your mind.", "2024-10-28T14:00:00"},
            {"Try a new sport", "Stay active and have fun.", "2024-02-15T08:00:00"},
            {"Declutter your workspace", "Improve productivity.", "2024-08-04T11:00:00"},
            {"Visit a new restaurant", "Try different cuisine.", "2024-11-07T19:00:00"},
            {"Go to a play", "Enjoy some live theater.", "2024-12-03T20:00:00"},
            {"Have a movie marathon", "Watch favorite films.", "2024-03-19T18:00:00"},
            {"Take a dance class", "Learn some new moves.", "2024-06-10T17:00:00"},
            {"Write a short story", "Get creative with words.", "2024-01-30T16:00:00"},
            {"Go bird watching", "Enjoy nature.", "2024-07-23T07:00:00"},
            {"Organize a game night", "Have fun with friends.", "2024-05-15T18:00:00"},
            {"Visit a botanical garden", "Appreciate plant life.", "2024-09-18T10:00:00"},
            {"Take a bubble bath", "Relax and unwind.", "2024-04-12T20:00:00"},
            {"Join a gym", "Stay fit and healthy.", "2024-10-20T06:00:00"},
            {"Start a blog", "Share your thoughts.", "2024-08-29T14:00:00"},
            {"Go stargazing", "Look at the night sky.", "2024-12-20T22:00:00"},
            {"Take a cooking class", "Learn from a professional chef.", "2024-11-25T17:00:00"},
            {"Try a new coffee shop", "Enjoy a fresh brew.", "2024-02-25T09:00:00"},
            {"Go to a fair", "Enjoy the attractions.", "2024-06-28T15:00:00"},
            {"Build a model kit", "Assemble and paint.", "2024-03-28T14:00:00"},
            {"Attend a networking event", "Meet new people.", "2024-06-07T18:00:00"},
            {"Make a scrapbook", "Collect memories.", "2024-01-17T10:00:00"},
            {"Visit a national park", "Enjoy natural beauty.", "2024-07-21T09:00:00"},
            {"Take a pottery class", "Create something unique.", "2024-05-09T16:00:00"}
    };
    
    @Transactional
    public void populateData() {
        List<User> users = createUsers();
        List<Todo> todos = createTodos();
        assignTodosToUsers(users, todos);
    }
    
    private List<Todo> createTodos() {
        
        return Arrays.stream(todosData).map((todosDatum) -> {
            Todo todo = new Todo();
            todo.setTitle(todosDatum[0]);
            todo.setComment(todosDatum[1]);
            todo.setDeadLine(LocalDateTime.parse(todosDatum[2]));
            todo.setDone(false);
            todo.setCreatedAt(LocalDateTime.now());
            return todoRepository.save(todo);
        }).collect(Collectors.toList());
    }
    
    private List<User> createUsers() {
        
        return IntStream.range(1, 21)
                .mapToObj(i -> {
                    User user = new User();
                    user.setUserName("user" + i);
                    user.setEmailAddress("user" + i + "@example.com");
                    user.setPassword(passwordEncoder.encode("PassWord" + i));
                    user.setCreatedAt(LocalDateTime.now());
                    return userRepository.save(user);
                })
                .collect(Collectors.toList());
    }
    
    private void assignTodosToUsers(List<User> users, List<Todo> todos) {
        Random random = new Random();
        users.forEach(user -> {
            for (int i = 0; i < 3; i++) {
                Todo todo = todos.get(random.nextInt(todos.size()));
                todo.setUser(user);
                todoRepository.save(todo);
            }
        });
    }
}
