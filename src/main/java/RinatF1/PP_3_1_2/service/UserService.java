package RinatF1.PP_3_1_2.service;

import RinatF1.PP_3_1_2.entity.User;
import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void addUser(User user);
    public void updateUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);
}
