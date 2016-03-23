1. To deploy with tomcat manager application (text/script mode) we need to start tomcat, then go to browser and enter following command:

http://localhost:8080/manager/text/deploy?path=/support&war=file:D:/support/support/UI/target/UI.war

where D:/support/support/UI/target/UI.war - path to war file in file system.




2. Go to your tomcat directory webapps/support/resources and copy and cut bootstrap, css, images, js folder.
Then go to your Apache folder and then into /htdocs/ . Create folder and name it support.
Paste cutted folders here.

Then go to conf and open httpd.conf. 

Load mod_jk : LoadModule jk_module modules/mod_jk.so

Include mod_jk properties : Include conf/extra/mod_jk.conf

Add to DocumentRoot and Directory /support 

DocumentRoot "D:/Apache24/htdocs/support"
<Directory "D:/Apache24/htdocs/support"> (where D:/Apache24 - path to your Apache)

Go to extra folder. Open mod_jk.conf and paste: 

<IfModule mod_jk.c>
	JkworkersFile conf/extra/workers.properties
	JkOptions +ForwardKeySize +ForwardURICompat -ForwardDirectories
	JkMount /support/* jmp
</IfModule>

In extra folder create workers.properties and paste into it: 

worker.list=jmp

worker.jmp.type=ajp13
worker.jmp.host=localhost
worker.jmp.port=8009

Go to httpd-vhosts.conf in extra folder. Add into it (D:/Apache24 - path to your Apache)

<VirtualHost *:80>
    ServerName localhost
	
    <Directory "D:/Apache24/htdocs/support/">
       Order allow,deny
       Allow from all
    </Directory>
</VirtualHost>