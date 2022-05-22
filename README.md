# spring-security-basic
This is my spring security learning udemy project notes 

### Simple default login
- Step 1: create 1 controller with 1 /welcome api, Then added spring-security dep into pom -> The login auth is provided by default when entering localhost:8080/welcome
- Step 2: add username & password in application.properties file instead of using default generated username, password

### Changing the default Security Configuration
- Since WebSecurityConfigurerAdapter deprecated, Create SecurityConfiguration using a SecurityFilterChain Bean to configure HttpSecurity or a WebSecurityCustomizer Bean to configure WebSecurity instead

### Modifying SecurityConfiguration as per our custom requirements
- using antMatcher("secured-api").authenticated(): tested with no auth in postman return 401 
- using antMatcher("not-secured-api").permitAll(): tested with no auth in postman return 200

 