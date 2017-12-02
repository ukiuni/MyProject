var app = new Vue({
	el: '#contents',
	data: {
		mail: "",
		error: null,
		registedMail: null
	},
	methods: {
		regist: function (mail) {
			error = null;
			axios.post("api/registrations", "mail=" + mail).then(
				() => {
					this.registedMail = mail;
				}).catch((e) => {
					this.error = "登録できないメールアドレスです。";
				});
		}
	}
});