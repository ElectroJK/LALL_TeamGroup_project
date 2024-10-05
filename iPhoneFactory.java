interface iPhoneFactory {
  iPhone createiPhone();
}
class iPhone15Factory implements iPhoneFactory {
  @Override
  public iPhone createiPhone() {
    return new iPhone15();
  }
}
