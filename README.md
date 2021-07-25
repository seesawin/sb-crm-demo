# sb-crm-demo

1. build jar
   ```
   1. go to the dir: /sb-crm-demo
   2. mvn clean package
   ```
3. run demo
   ```
   1. go to the dir: /sb-crm-demo/document
   2. docker-compose up -d
   ```
3. [open swagger](http://localhost:9100/swagger-ui.html#/)

4. get the platform user's token 

   4.1.login platform user
   ```
   account/password
   adm/111111
   lead/111111
   customer/111111
   ```
   ![img_1.png](img.png)
   4.2.copy the token
   ![img_2.png](img_2.png)
   4.3 authorize
   ![img_3.png](img_3.png)
   ![img_4.png](img_4.png)
   
5. start to add/update/delete the client or company data
   

