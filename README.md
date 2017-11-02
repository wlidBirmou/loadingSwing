# loadingSwing
Java Swing easy to use loading component
to see the rendering download and execute LoadingSwingDemo.jar 
in the root of the repository.<br />

### Quick guide

We instanciate one of subclasses of LoadingPercentage class: <br />
LoadingPie loading=new LoadingPie();

We can change the looking of the loading component through various methods
```
loading.setBackgroundSketchColor(Color.WHITE);
loading.setFillingColor(Color.RED);
loading.setTextColor(Color.BLACK);
```
add the loading component to any Swing Container:<br />
`panel.add(loading);`<br />

Set the loading percentage depending on your background processing, with<br />
`loading.setPosition(n) //n have to be an integer between 0 and 100`<br />

