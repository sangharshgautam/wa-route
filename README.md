# wa-route
[STDOUT] [-19, 9, 52, -10, -89, 97, -119, 55, 87, 88, 33, -67, 13, 94, -49, -56, -104, 60, -69, 43]

[STDOUT] ENCODED ID--> %C3%AD%094%C3%B6%C2%A7a%C2%897WX%21%C2%BD%0D%5E%C3%8F%C3%88%C2%98%3C%C2%BB%2B

[STDERR] Jul 03, 2015 3:13:27 PM org.glassfish.jersey.filter.LoggingFilter log

[STDERR] INFO: 1 * Sending client request on thread main

[STDERR] 1 > GET https://v.whatsapp.net/v2/code?cc=91&in=9958674455&lg=en&lc=IN&method=sms&sim_mcc=404&sim_mnc=000&token=5f4738a2ef8677620d38cb44feb60f01&id=%C3%AD%094%C3%B6%C2%A7a%C2%897WX!%C2%BD%0D%5E%C3%8F%C3%88%C2%98%3C%C2%BB%2B

[STDERR] 1 > Accept: application/json

[STDERR] 1 > User-Agent: WhatsApp/2.12.82 S40Version/14.26 Device/Nokia302

[STDERR] 

[STDERR] Jul 03, 2015 3:13:28 PM org.glassfish.jersey.filter.LoggingFilter log

[STDERR] INFO: 1 * Client response received on thread main

[STDERR] 1 < 200

[STDERR] 1 < Connection: close

[STDERR] 1 < Content-Length: 63

[STDERR] 1 < Content-Type: text/json ; charset=utf-8

[STDERR] 1 < Date: Fri, 03 Jul 2015 15:13:28 GMT

[STDERR] 1 < Server: Yaws 1.99

[STDERR] 

[STDOUT] {"status":"sent","length":6,"method":"sms","retry_after":1805}
