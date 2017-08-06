(function($){
	$.fn.hello = function(){
		this.text('hello');
		return this;	//chain 형태로 동작 가능하게
	};
})(jQuery);
