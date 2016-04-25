all:	index.md
	pandoc -s index.md -o index.html -c 'https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600,700' -c 'https://fonts.googleapis.com/css?family=Ubuntu+Mono:400,700,400italic,700italic' -c 'http://dillinger.io/css/app.css' -c 'https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.2.0/katex.min.css'
