var EC = protractor.ExpectedConditions;
// spec.js
describe('Login functionality', function() {
  // using browser.driver because login page is not Angular application
  it('should login correctly', function() {
    browser.driver.get('http://dev.assignforce.revaturelabs.com/');
    var VPUsername = "test.vpoftech@revature.com.int1";
    var VPPassword = "yuvi1712";
    var TrainerUsername = "test.trainer@revature.com.int1";
    var TrainerPassword = "trainer123";
    browser.driver.findElement(by.id('username')).sendKeys(VPUsername);
    browser.driver.findElement(by.id('password')).sendKeys(VPPassword);
    browser.driver.findElement(by.id('Login')).click();
  });
});

describe('Overview page', function(){
  it('should be appearing', function() {
    // Waits for the URL to match /home.
    browser.wait(EC.urlContains('/home'), 5000);
  });
});

describe('Batches page', function(){
  it('should be appearing', function(){
    browser.get('http://dev.assignforce.revaturelabs.com/batches');
    // Waits for the URL to match /batches
    browser.wait(EC.urlContains('/batches'), 5000);
  });
  it('should input curriculum', function(){
    var curriculum = element(by.model('bCtrl.batch.curriculum'));
    curriculum.sendKeys('.NET');
    expect(curriculum.getAttribute('value')).toBe('.NET');
  });
  it('should input focus', function(){
    var curriculum = element(by.model('bCtrl.batch.focus'));
    var opts = element(by.repeater('skills in bCtrl.skills'));
    curriculum.sendKeys('No Focus');
    expect(curriculum.getAttribute('value')).toBe('No Focus');
  });
  it('should input start date', function(){
    var date = element(by.model('bCtrl.batch.startDate'));
    date.sendKeys('12/11/2017');
    expect(curriculum.getAttribute('value')).toBe('12/11/2017');
  });
  it('should input end date', function(){
    var date = element(by.model('bCtrl.batch.endDate'));
    date.sendKeys('03/09/2018');
    expect(curriculum.getAttribute('value')).toBe('03/09/2018');
  });
  it('should have accurate week span', function(){
    var span = element(by.model('bCtrl.batch.weekSpan'));
    expect(span.getAttribute('value')).toContain('13');
  });
  it('should have a specific batch name', function(){
    var name = element(by.model('bCtrl.batch.name'));
    expect(name.getAttribute('value')).toContain('1712 Dec11 .NET');
  });
  it('should take batch name input', function(){
    var name = element(by.model('bCtrl.batch.name'));
    name.sendKeys('test name');
    expect(name.getAttribute('value')).toBe('test name');
  });
  it('should take batch trainer input', function(){
    var name = element(by.model('bCtrl.batch.trainer'));
    name.sendKeys('Tom Brady');
    expect(name.getAttribute('value')).toContain('Tom Brady');
  });
  it('should take batch co-trainer input', function(){
    var name = element(by.model('bCtrl.batch.cotrainer'));
    name.sendKeys('Matt Barkley');
    expect(name.getAttribute('value')).toContain('Tom Brady');
  });
  it('should take batch location input', function(){
    var location = element(by.model('bCtrl.batch.location'));
    location.sendKeys('Revature HQ - Reston, VA');
    expect(location.getAttribute('value')).toBe('Revature HQ - Reston, VA');
  });
  it('should take batch building input', function(){
    var building = element(by.model('bCtrl.batch.building'));
    building.sendKeys('Training');
    expect(building.getAttribute('value')).toContain('Training');
  });
  it('should take batch room input', function(){
    var room = element(by.model('bCtrl.batch.room'));
    room.sendKeys('110');
    expect(room.getAttribute('value')).toContain('110');
  });
});
