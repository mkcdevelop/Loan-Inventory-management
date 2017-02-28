function validateform(){
	var username=document.addbanker.username.value
	var firstname=document.addbanker.firstname.value
	var lastname=document.addbanker.lastname.value
	var dateofbirth=document.addbanker.dateofbirth.value
	var city=document.addbanker.city.value
	var password=document.addbanker.password.value
	var phonenumber=document.addbanker.phonenumber.value
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

