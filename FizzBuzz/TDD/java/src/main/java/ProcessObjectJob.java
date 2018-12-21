enum ProcessObjectJob {
  $;

  static Object process(final Object input) throws Exception {
      if(input instanceof int[]) {
	  return ProcessListJob.process((int []) input);
      }
      if(input instanceof Integer) {
	  return ProcessJob.process((int) input);
      }
      throw new UnexpectedObjectTypeException(input);
  }
}
