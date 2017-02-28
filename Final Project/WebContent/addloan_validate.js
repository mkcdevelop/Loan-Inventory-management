function validateform(){
	var loanamount=document.addloan.loanamount.value
	var interestrate=document.addloanform.intrestrate.value
	var itemtype=documenet.addloanform.itemtype.value
	var itemname=document.addloanform.itemname.value
	var totalweight=document.addloanform.totalweight.value
	var netweight=document.addloanform.netweight.value
	
	
	if(isNaN(loanamount)||loanamount==null||loanamount==""){
		alert("Loan Amount must be numeric and should not be empty")
		return false
	}
	else if(interestrate==null){
		alert("interest rate should be selected")
		return false
	}
	else if(itemtype==null){
		alert("item type should be selected")
		return false
	}
	else if(itemname==null){
		alert("itemname must be selected")
		return false
	}
	else if(totalweight==null||totalweight==""||isNaN(totalweight)){
		alert("total weight must be a number and cannot be empty")
		return false
	}
	else if(netweight==null||netweight==""||isNaN(netweight)){
		alert("netweight must be a number and cannot be empty")
		return false
	}
}