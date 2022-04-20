(use-modules (guix gexp)
             (guix packages)
             (guix build-system trivial)
             (gnu packages base)
	     (gnu packages java)
	     (gnu packages compression)
             (gnu packages clojure)
	     (nongnu packages clojure)
	     (kreved packages clojure))

(package
  (name "http-comp")
  (version "0.0.1")
  (source (local-file "."))
  (build-system trivial-build-system)
  (native-inputs
   (list clojure-tools
	 clj-kondo
	 gnu-make
	 unzip
	 babashka
	 (list openjdk16 "jdk")))
  (home-page "")
  (synopsis "")
  (description "")
  (license #f))
