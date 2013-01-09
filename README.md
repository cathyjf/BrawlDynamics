# Brawl Dynamics

This Applet provides a basic simulation of the physics of Super Smash Bros.
Brawl. It was created by [Cathy J. Fitzpatrick][cathyjf] in January 2009 and is
based on what was known about Brawl mechanics at that time. As such, it may
not be completely accurate, but it does provide an approximation of the physics.

## Theory

The theory behind the physics simulated by this program comes from the
following two articles:

+ "[Brawl Mechanics: Damage & Knockback Formulae][brawl-mechanics]"
  by [Cathy J. Fitzpatrick][cathyjf] and Amazing Ampharos ([Chris Immele][AA])

+ "[Brawl Dynamics: Velocity, Forces, Knockback][brawl-dynamics]"
  by [Cathy J. Fitzpatrick][cathyjf]

## Try the applet

You can [try the Applet in your browser][applet] right now.

## How to compile and run your own copy of the Applet

### Dependencies

+ You will need a JDK to compile the program, such as [OpenJDK][].
+ [Apache Ant][] is used to build the program.

There are NetBeans project files in the repository. However, NetBeans is _not_
required to build or use the program.

### Build the Applet

Change into the directory where you cloned the repository and try

```bash
ant jar
```

If the build succeeds, the output will end with something like this:

```
BUILD SUCCESSFUL
Total time: 3 seconds
```

After building the program, a `dist` directory has been created which contains
`dist/BrawlDynamics.jar` (the program itself) and
`dist/lib/swing-layout-1.0.4.jar` (a standard library used by the program).

### Embed the Applet in a web page

You can embed the Applet in a web page with the following HTML snippet:

```html
<object type="application/x-java-applet" width="494" height="440">
    <param name="code" value="dynamics.SimulationApplet" />
    <param name="archive" value="dist/BrawlDynamics.jar" />
    This Applet requires a Java browser plugin.
</object>
```

Note that the file `dist/lib/swing-layout-1.0.4.jar` must be present for this
to work, even though it is not mentioned by name in the HTML code.

## Licence

This program is licensed under the [GNU Affero General Public License][agpl3],
version 3 or later.

## Credits

+ [Cathy J. Fitzpatrick][cathyjf] (cathyjf) created this program.

[brawl-mechanics]: https://cathyjf.com/brawl/brawl-mechanics-2008-12-13.pdf
[brawl-dynamics]: https://cathyjf.com/brawl/brawl-dynamics-2009-01-18.pdf
[applet]: http://cathyjf.github.com/BrawlDynamics/
[OpenJDK]: http://openjdk.java.net
[Apache Ant]: https://ant.apache.org/
[agpl3]: http://www.fsf.org/licensing/licenses/agpl-3.0.html
[cathyjf]: https://cathyjf.com
[AA]: http://www.smashboards.com/member.php?userid=88497
