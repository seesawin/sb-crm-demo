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
   
   | account | password |
   | :-----| ----: |
   | super | 111111 |
   | manager | 111111 |
   | operator | 111111 |

   ![img_5.png](img_5.png)
   4.2.copy the token
   ![img_2.png](img_2.png)
   4.3 authorize
   ![img_3.png](img_3.png)
   ![img_6.png](img_6.png)
   
5. start to add/update/delete the client or company data
   

