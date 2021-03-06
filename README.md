# cljs-boilerplate

BETA

An attempt to bring together the best practices of Clojure, ClojureScript, HTML5
Boilerplate, and Google Closure.  The end goal is an environment for quick
development (eg no manual compiling) and an efficient production deploy (eg
mimification and advanced cljs compiling).

cljs-boilerplate should provide reasonable defaults to get a site up and running
quickly, but allow components to be added or removed easily when desired.  

## Demo

Hopefully the demo is up at http://cljs-boilerplate.elasticbeanstalk.com/

## Usage

Not all dependencies are uploaded to clojars, so if lein/maven complains check
github for the latest version.

To run in development mode:

* `lein2 ring server &`

To run in production mode:

* `cd build && ant`
* `lein2 with-profile prod ring server`
* `lein2 with-profile prod beanstalk deploy production # or uberwar`

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
