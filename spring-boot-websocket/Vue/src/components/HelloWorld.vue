<template>    
	<div>       
		<h1>测试webSocket</h1>
		<button @click="getWebsocket">点击请求后台数据</button>
        <div id ="aaa" style="height: 300px; width: 400px; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;"></div>
    </div>
</template>
<script>
export default {        
	created() { // 页面创建生命周期函数              
		this.initWebSocket()        
	},        
	destroyed: function () { // 离开页面生命周期函数              
		this.websocketclose();        
	},        
	methods: {            
		initWebSocket: function () {                
			// WebSocket与普通的请求所用协议有所不同，ws等同于http，wss等同于https                
			this.websock = new WebSocket("ws://localhost:8080/websocket/DPS007");                
			this.websock.onopen = this.websocketonopen;                
			this.websock.onerror = this.websocketonerror;                
			this.websock.onmessage = this.websocketonmessage;                
			this.websock.onclose = this.websocketclose;              
		},              
		websocketonopen: function () {                
			console.log("WebSocket连接成功");              
		},              
		websocketonerror: function (e) {                
			console.log("WebSocket连接发生错误" + e);              
		},              
		websocketonmessage: function (e) {                
			console.log(e.data);                // console.log(e);
            document.getElementById('aaa').innerHTML=e.data
        },
		websocketclose: function (e) {                
			console.log("connection closed ");              
		},              
		getWebsocket:function() {                
			let url = "http://localhost:8080/xdx/text?shipId=DPS007"                
			// 这里只是一个基于axios的ajax请求，你可以换成你的请求格式                
			// this.$ajax.get(url)        

			// 不想安装axios了，这里使用最原始的 js去请求
			var xhr = new XMLHttpRequest () ;
			xhr.open('get',url,true);
			xhr.send();
        }
	}    
}
</script>
<style >
</style>


