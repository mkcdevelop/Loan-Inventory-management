function validateform(){
	var username=document.addcustomer.username.value
	var firstname=document.addcustomer.firstname.value
	var lastname=document.addcustomer.lastname.value
	var dateofbirth=document.addcustomer.dateofbirth.value
	var city=document.addcustomer.city.value
	var password=document.addcustomer.password.value
	var phonenumber=document.addcustomer.phonenumber.value
	var phn=/^\d{10}$/;
	
	if(username==null||username==""){
		alert("enter username")
		return false
	}
	else if(firstname==null||firstname==""){
		alert("enter first name")
		return false
	}
	else if(lastname==null||lastname==""){
		alert("enter last name")
		return false
	}
	else if(dateofbirth==""||dateofbirth==null){
		alert("enter date")
		return false
	}
	else if(phonenumber==null||phonenumber==""||isNaN(phonenumber)){
		alert("enter a phone number")
		return false
	}
	else if(city==null||city==""){
		alert("enter city name")
		return false
	}
	else if(password==null||password==""){
		alert("enter password")
		return false
	}
	
}

