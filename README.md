# PasswordMan 
Your online bank password belongs to you and just you. Not to tools which will gladly sell your data for a few thousand bucks. Enter PasswordMan

### Functionalities
- Given a username and the application name it generates and stores a password into mysql db
- Given a username and application name it returns the existing password
- Given a username, application, and password it stores the given password into the db

### The Password Generated has the following characteristics:
- A random string of length between 12 and 15
- Will contain at least 1 of caps alphabets, 1 of smallcase alphabets, 1 of numerals between 0 to 9, and 1 of special character


### Prerequisites
- Java 17 or above
- MySQL server running on your local instance

### Running the Application
- The Application can be run by running PasswordmanApplication.class

### APIs
  - /v1/passwordman/api/generate
  - /v1/passwordman/api/get

