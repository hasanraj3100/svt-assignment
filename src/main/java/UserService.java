
interface UserRepository {
    String findById(int id);
}


public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findUserById(int id) {
        return userRepository.findById(id);
    }
}
