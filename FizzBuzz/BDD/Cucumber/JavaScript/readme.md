## Project Setup
### MacOS
- brew install node
- npm install -D jasmine
- npm install -g jasmine
- npm init ->/ ** (optional)
- jasmine init
- jasmine
- npm install -g chai@latest
- npm install -D chai@latest
- npm install --save-dev cucumber

## 
- Run Tests
```
$ ./node_modules/.bin/cucumber-js features/ -r steps/
```
For the last command in `package.json` script entry `evaluate-examples`. Therefore, the following substitutes:

```
$ npm run evaluate-examples
```

- Derive new specification

```
$ npm run cucumber
```

## Reference:
- https://blog.risingstack.com/node-hero-node-js-project-structure-tutorial/
- https://www.chaijs.com/api/bdd/
- https://nodejs.org/en/download/package-manager/
- https://jasmine.github.io/2.0/node.html
- https://docs.cucumber.io/guides/overview/

