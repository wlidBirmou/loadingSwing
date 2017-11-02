# loadingSwing
Java Swing easy to use loading component
to see the rendering download and execute LoadingSwingDemo.jar 
in the root of the repository

### Quick guide

We instanciate one of subclasses of LoadingPercentage class: 
LoadingPie loading=new LoadingPie();

We can change the looking of the loading component through various methods
```
loading.setBackgroundSketchColor(Color.WHITE);
loading.setFillingColor(Color.RED);
loading.setTextColor(Color.BLACK);
```
add the LoadingPercentage to any Swing Container:
`panel.add(loading);`

We set the loading percentage depending on your background processing, with
`loading.setPosition(n) //n have to be an integer between 0 and 100`

