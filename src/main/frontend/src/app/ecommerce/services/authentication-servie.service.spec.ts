import { TestBed, inject } from '@angular/core/testing';

import { AuthenticationServieService } from './authentication-servie.service';

describe('AuthenticationServieService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthenticationServieService]
    });
  });

  it('should be created', inject([AuthenticationServieService], (service: AuthenticationServieService) => {
    expect(service).toBeTruthy();
  }));
});
