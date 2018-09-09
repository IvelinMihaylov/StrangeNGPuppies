# NGPuppies
Telerik Academy - Payment System

New Generation Puppies is a payment system which allows banks and other financial institutions could pay the monthly bills of their customers using that application.

# Rest API

### Get list of all bills:
 
 api/bill/listAll
 
### Get history of bills:

  api/bill/history
  
### Get non-ready bills:
  
  api/bill/nonReady

### Get bill by id:

  api/bill/byID/{id}

### Do all bills with status accept:

  api/bill/AllBillsStatusAccept
  
### Do all bills with status canceled:

  api/bill/AllBillsStatusCancel
  
### Do all bill with status accept:

  api/bill//BillStatusAccept/{id}

### Do all bill with status canceled:

  api/bill/BillStatusCancel/{id}

### Crete bill :
  api/bill/create

### Get all service:
  api/service/allservices
  
### Get service by id:

  api/service/byId/{id}

### Get list of all subscribers:

  api/subscriber/getAll
  
### Get subscriber by id:

  api/subscriber/byID/{phonenumber}
  
### Get top 10 payers:

  api/subscriber/getTopTenPayer
  
### Get top 10 last payment:

  api/subscriber/getTopTenLastPayment
    
### Create subscriber:

  api/subscriber/create
  
### Update an existing subscriber:

  api/subscriber/update
  
### Delete subscriber by phonenumber(id):

  api/subscriber/delete/{phonenumber}
  
### Get list of accounts:

  api/user/listAll

### Get account by username:

  api/user/getUserByUsername/{username}
  
### Get account by id:

  api/user/getByID/{id}

### Update account by id:

  api/user/updateUser/{id}
  
### Delete account by id:

  api/user/deleteUser/{id}
  
### Create accoutn for client:

  api/user/createClient
  
### Create accoutn for administrator:

  api/user/createAdministrator
