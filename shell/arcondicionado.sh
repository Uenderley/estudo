#!/bin/bash
curl -i -s -k  -X 'POST' \
  -H 'Content-type: text/xml' -H 'User-Agent: Java(tm) 2 SDK, Standard Edition v1.8.0_111 Java/1.8.0_111' \
  -b '_ga=GA1.3.1507362397.1447796941; __utma=260825096.1507362397.1447796941.1485206312.1506024912.9; __utmz=260825096.1506024912.9.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); ajs_user_id=null; ajs_group_id=null; ajs_anonymous_id=%2200000000000000000000000000%22; WT_FPC=id=192.168.206.250-1464359200.30584800:lv=1506024916750:ss=1506024911775; __utmc=260825096' \
  --data-binary $'<?xml version=\"1.0\" encoding=\"UTF-8\"?>\x0d\x0a<Packet>\x0d\x0a <Command>setRequest</Command>\x0d\x0a <DatabaseManager>\x0d\x0a  <Mnet Group=\"40\" Drive=\"ON\" SetTemp=\"17.0\" AirDirection=\"SWING\" FanSpeed=\"HIGH\" />\x0d\x0a  <Mnet Group=\"42\" Drive=\"ON\" SetTemp=\"17.0\" AirDirection=\"SWING\" FanSpeed=\"HIGH\" />\x0d\x0a  <Mnet Group=\"44\" Drive=\"ON\" SetTemp=\"17.0\" AirDirection=\"SWING\" FanSpeed=\"HIGH\" />\x0d\x0a </DatabaseManager>\x0d\x0a</Packet>\x0d\x0a' \
  'http://gb1.tse.jus.br/servlet/MIMEReceiveServlet'
