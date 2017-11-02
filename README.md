# loadingSwing
Java Swing easy to use loading component
to see the rendering, download and execute LoadingSwingDemo.jar 
in the root of the repository

### Quick guide

We instanciate one of subclasses of LoadingPercentage class: <br />
LoadingPie loading=new LoadingPie();<br />

We can change the looking of the loading component through various methods<br />
loading.setBackgroundSketchColor(Color.WHITE);<br />
loading.setFillingColor(Color.RED);<br />
loading.setTextColor(Color.BLACK);<br />

add the LoadingPercentage to any Swing Container:<br />
panel.add(loading);<br />

We set the loading percentage depending on your background processing, with:<br />
loading.setPosition(n) //n have to be an integer between 0 and 100<br />
