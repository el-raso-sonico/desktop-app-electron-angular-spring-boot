import { TestBed } from '@angular/core/testing';

import { GeneradorFichaService } from './generador-ficha.service';

describe('GeneradorFichaService', () => {
  let service: GeneradorFichaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GeneradorFichaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
