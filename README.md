//TODO
1.Resolve problem with empty value of fileName validation in ImageController.
2.Operate files without extension in name. And develop mechanism fo touching and detaching extension to fileName.
3.Move same logic related with fileName validation in separated method.
4.Add collection of image paths to product entity.
5.Add logger.
6.Think about ports (replication)
7.Expose only gateway
8.fix gateway start problem (add timeout or ping gateway endpoint)
9.Configure line endings on git
10.Bind services to exact ip. Configure network

for dev dependencies npm install --save-dev @angular-devkit/build-angular

SET @@global.time_zone='+00:00'

Basic Auth

rootClient
rootPassword

Headers

"Content-Type" "application/x-www-form-urlencoded"

body {
grant_type password
user rootUser
password rootUserPassword
}