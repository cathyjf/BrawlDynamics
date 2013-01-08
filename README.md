# Brawl Dynamics

This Applet provides a basic simulation of the physics of Super Smash Bros. Brawl. It was created in by [Cathy Fitzpatrick][cathyjf] in January 2009 and is based on what was known about Brawl mechanics at that time. As such, it may not be completely accurate, but it does provide an approximation of the physics.

## Try the applet

TODO

## Theory

TODO

## How to compile and run your own copy of the Applet

### Dependencies

+ You will need a JDK to compile the program, such as [OpenJDK][].
+ [Apache Ant][] is used to build the program.

There are NetBeans project files in the repository. However, NetBeans is _not_
required to build or use the program.

### Build the Applet

Change into the directory where you cloned the repository and try

```bash
# Build the program.
ant jar
```

If the build succeeds, the output will end with something like this:

```
BUILD SUCCESSFUL
Total time: 3 seconds
```

After building the program, a `dist` created has been created which contains
`dist/BrawlDynamics.jar` (the program itself) and
`dist/lib/swing-layout-1.0.4.jar` (a standard library used by the program).

### Embed the Applet in a web page

You can embed the Applet in a web page with the following HTML5 snippet:

```html
<object type="application/x-java-applet" width="494" height="440">
    <param name="code"
        value="dynamics.SimulationApplet" />
    <param name="archive"
        value="dist/BrawlDynamics.jar,dist/lib/swing-layout-1.0.3.jar" />
    This Applet requires a Java browser plugin.
</object>
```

You will have to change the path of `dist/BrawlDynamics.jar` and
`dist/lib/swing-layout-1.0.4.jar` in the second `<param>` tag if those files
are located somewhere else relative to the HTML page.

## Licence

This program is licensed under the [GNU Affero General Public License][agpl3],
version 3 or later.

## Credits

+ [Cathy Fitzpatrick][cathyjf] (cathyjf) created this program.


[OpenJDK]: http://openjdk.java.net
[Apache Ant]: https://ant.apache.org/
[agpl3]: http://www.fsf.org/licensing/licenses/agpl-3.0.html
[cathyjf]: https://cathyjf.com
