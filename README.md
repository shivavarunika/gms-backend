entities:1.User_profile:
	user_id (primary key)
	user_name (foreign key)
	user_password
	user_phone number
	user_role
2.Trainers:{done}
	trainer_name (primary key)
	exp_years 
	specialization
	picture_url
	achievements
3.Book Trainer:
	trainer_name (primary key)
	picture_url
	specializtion
	booking_satuts
4.Packages:{done}
	package_imgurl
	package_name (primary key)
	package_price
	package_duration
	package_description

5.products:{done}
	product_imgurl
	product_name (primary key)
	product_price
6.my schedule:
	scheduled_time
