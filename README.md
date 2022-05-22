# spring-security-basic
This is my spring security learning udemy project 

### Simple default login
- Step 1: create 1 controller with 1 /welcome api, Then added spring-security dep into pom -> The login auth is provided by default when entering localhost:8080/welcome
- Step 2: add username & password in application.properties file instead of using default generated username, password

### Changing the default Security Configuration
- Since WebSecurityConfigurerAdapter deprecated, Use a SecurityFilterChain Bean to configure HttpSecurity or a WebSecurityCustomizer Bean to configure WebSecurity instead
 