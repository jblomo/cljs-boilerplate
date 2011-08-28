# cljs-boilerplate

ALPHA

An attempt to bring together the best practices of Clojure, ClojureScript, HTML5
Boilerplate, and Google Closure.  The end goal is an environment for quick
development (eg no manual compiling) and an efficient production deploy (eg
mimification and advanced cljs compiling).

## Demo

Hopefully the demo is up at http://cljs-boilerplate.elasticbeanstalk.com/

## Usage

Much of the setup is currently manual.  Read
https://github.com/maxweber/cljs-devmode to understand how to setup auto
compilation of cljs scripts.  Read
http://html5boilerplate.com/docs/#Build-script to understand how to setup
compilation of the templates.

To run in development mode:

* ./cljs-devmode.sh & # this is created by the cljs-devmode process above
* lein ring server &

To run in production mode:

* def *dev-mode* false in settings
* cd build && ant
* lein beanstalk deploy production || lein ring uberwar

## License

Major components:

* Modernizr: MIT/BSD license
* jQuery: MIT/GPL license
* DD_belatedPNG: MIT license
* YUI Profiling: BSD license
* HTML5Doctor CSS reset: Public Domain
* CSS Reset Reloaded: Public Domain
* HTML5 Boilerplate: The Unlicense (http://unlicense.org/, aka: public domain)

Everything else:

Copyright (C) 2011 Jim Blomo

Distributed under the Eclipse Public License, the same as Clojure.
