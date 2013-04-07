$("document").ready(function(){
	var footerImages=$(".footerImage");
	footerImages.hover(animateFooter,resetFooter);
		
	var rightIcon=$(".rightIcon");
	rightIcon.hover(animateRightIcon,resetRightIcon);
	
	var footerIcon=$(".footerIcon");
	footerIcon.hover(animateFooterIcon,resetFooterIcon);
	
	var facebookImage=$("#facebookImage");
	facebookImage.hover(animateFacebookImage,resetFacebookImage);
	
	var twitterImage=$("#twitterImage");
	twitterImage.hover(animateTwitterImage,resetTwitterImage);
	
	var gPlusImage=$("#gPlusImage");
	gPlusImage.hover(animateGPlusImage,resetGPlusImage);
});

function animateFacebookImage(){
		$(this).attr("src", 'images/fbL.png');
}

function resetFacebookImage(){
	$(this).attr("src", 'images/fb.png');
}

function animateTwitterImage(){
	$(this).attr("src", 'images/twitterL.png');
}

function resetTwitterImage(){
	$(this).attr("src", 'images/twitter.png');
}

function animateGPlusImage(){
	$(this).attr("src", 'images/gPlusL.png');
}

function resetGPlusImage(){
	$(this).attr("src", 'images/gPlus.png');
}



function animateFooter(){
	$(this).animate({
		width: "100px",
		height: "100px"
	  }, 200 );
}

function resetFooter(){
	$(this).animate({
		width: "70px",
		height: "70px"
	  }, 200 );
}

function animateRightIcon(){
	$(this).animate({
		width: "50px",
		height: "50px"
	  }, 200 );
}

function resetRightIcon(){
	$(this).animate({
		width: "35px",
		height: "35px"
	  }, 200 );
}

function animateFooterIcon(){
}

function resetFooterIcon(){
}
