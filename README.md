//TODO
1. Add mechanism to sort attribute values list.
2. Check that id exists on update.
3. Add Controller Advise.
4. Add Filtering (will search chars in record cell)
5.Add logger.
6.Think about ports (replication)
7. Write tests
8.fix gateway start problem (add timeout or ping gateway endpoint)
9.Configure line endings on git
10.Bind services to exact ip. Configure network
11.Read about swarm
12. Повертати адекватний шлях до створеного ресурсу в респонсію

for dev dependencies npm install --save-dev @angular-devkit/build-angular

SET @@global.time_zone='+00:00'


Generate Token {
    url: http://localhost:8200/oauth/token

    Basic Auth {
        Client ID: rootClient
        Client Password: rootPassword
    }
    
    Headers {
        "Content-Type" "application/x-www-form-urlencoded"
    }
    
    body {
        grant_type: password
        username: rootUser
        password: rootUserPassword
    }
}
