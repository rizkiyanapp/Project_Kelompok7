# Project_Kelompok7
Aplikasi Pemesanan Transportasi Online - Kelompok 7 - IF3801
Judul Aplikasi : RIDEUP
Scrum Master : Rizkiyana Prima Putra (1301140181)
Scrum Team :  - Atika Mardhotillah (1301144061)
              - Rana Renes Rengga (1301144351)


CLASS DIAGRAM DETAIL
====================

People :
#Atribute
- name : String
- email : String
- noIdentity : String
- birth : Date
- gender : char
- address : String
- number : String

#Method
+ setName(name : String)
+ getName() : String
+ setEmail(email : String)
+ getEmail() : String
+ setNoIdendity(noIdentity : String)
+ getNoIdentity() : String
+ setBirth(birth : Date)
+ getBirth() : Date
+ setGender(gender : char)
+ getGender() : char
+ setAddress(address : String)
+ getAddress() : String
+ setNumber(number : String
+ getNumber() : String


Customer :
#Atribute
- orders : Order[]
- idCustomer: String
- nOrder : int

#Method
+ Customer(name, email, number)
+ Customer(name, email, number, noIdentity)
+ Customer(name, email, number, noIdentity, gender)
+ createOrder(type, idCounter, position, destination, distance, detail)
+ removeOrder(orderId : String)
+ getOrders(index : int) : Order
+ getIdCustomer() : String
+ getNOrder() : int


Driver :
#Atribute
- orders : Order[]
- idDriver : String
- nOrder : int

#Method
+ Driver(name, email, number)
+ Driver(name, email, number, noIdentity)
+ Driver(name, email, number, noIdentity, gender)
+ addOrder(o : Order)
+ removeOrder(index : int)
+ getOrders(index : int) : Order
+ getIdDriver() : String
+ getNOrder() : int


Order :
#Atribute
- orderId : String
- position : String
- destination : String
- distance : int
- price : long
- status : boolean
- detail : String
- type : int

#Method
+ Order(type, orderId, position, destination, distance, detail)
+ Order(type, position, destination, distance, detail)
+ getType() : int
+ getId() : String
+ getPosition() : String
+ getDestination() : String
+ getDistance() : int
+ setPrice(price : long)
+ getPrice() : long
+ setStatus(status : boolean)
+ getStatus() : boolean
+ setDetail(detail : String)
+ getDetail() : String


Courier :
#Atribute
- courierId : String
- receiverName : String
- receiverNumber : String

#Method
+ Courier(type, courierId, receiverName, receiverNumber, position, destination, distance, detail)
+ getId() : String
+ getReceiverName() : String
+ getReceiverNumber() : String


FoodCourier :
#Atribute
- foodOrder : Food
- foodCourierId : String
- qty : int
- price : long

#Method
+ FoodCourier(type, foodCourierId, position, destination, distance, detail)
+ addFood(f : Food, qty : int)
+ removeFood()
+ getId() : String
+ getFoodOrder() : Food
+ getQty() : int
+ setPrice(price : long)
+ getPrice() : long


Food :
#Atribute
- idFood : String
- foodName : String
- foodPrice : long

#Method
+ Food(idFood, foodName, foodPrice)
+ getIdFood() : String
+ getName() : String
+ getPrice() : long


FUNGSIONALITAS
==============

1. Search Customer by ID
2. Search Driver by ID
3. Search Order by ID
4. Search Customer by Order ID
5. Search Driver by Order ID
6. View Data Customer
7. View Data Driver
8. View Data Order
9. View Available Order
10. View Data Transaksi
